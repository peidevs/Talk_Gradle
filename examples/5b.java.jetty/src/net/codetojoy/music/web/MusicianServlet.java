
package net.codetojoy.music.web;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
import org.hibernate.*;

import net.codetojoy.music.common.*;
import net.codetojoy.music.pojo.*;

// This class is just an example for the build! 
// Yes, it is an egregious violation of MVC principles! 
// Work with me, here, people.
public class MusicianServlet extends HttpServlet {
    private SimpleTxnManager txnManager = new SimpleTxnManager();

    public void init(ServletConfig config) throws ServletException {
        txnManager.openTransaction();
                
        String[] names = { "Mozart", "Elvis", "Jimi Hendrix", "Ani DiFranco" };

        for (String name : names) {
            Musician musician = new Musician();
            musician.setName(name);
            txnManager.getSession().save(musician);            
        }
        
        txnManager.commitTransaction();
    }
       
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
                      throws ServletException, IOException {
        txnManager.openTransaction();

        Query query = txnManager.getSession().createQuery("from Musician");

        @SuppressWarnings("unchecked")
        List<Musician> results = (List<Musician>) query.list();

        PrintWriter out = response.getWriter();
        out.println("<html><body><ul>");

        for (Musician m : results) {
            out.println("<li>" + m.getName() + "</li>");
        }

        out.println("</ul>");
        out.println("<br/><p> retrieved at: " + new Date().toString() + "</p>");
        out.println("</body></html>");
        out.close();

        txnManager.commitTransaction();
    }

    public void destroy() {
        txnManager.shutdown();
    }
}
