package alienBasicExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        Alien alien = new Alien();
        alien.setAid(101);
        alien.setColor("Green");

        AlienName alienName = new AlienName();
        alienName.setfName("Andrei");
        alienName.setlName("Lungu");
        alienName.setmName("Sebastian");
        alien.setAname(alienName);

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(alien);

        tx.commit();

        System.out.println(alien);
    }
}
