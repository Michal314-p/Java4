package ziarna;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class Ziarno0 extends JPanel implements Externalizable
{
    private Color ziarno_kolor;
    private int ziarno_wartosc;
    private String ziarno_tekst;


    protected PropertyChangeSupport change_support = new PropertyChangeSupport(this);
    protected VetoableChangeSupport vetoable_support = new VetoableChangeSupport(this);

    protected EventListenerList listener_list = new EventListenerList();

    public Ziarno0()
    {
        setBorder(BorderFactory.createEtchedBorder());
        ziarno_wartosc = 14;
        ziarno_tekst = "Test Arbuz";
        ziarno_kolor = Color.blue;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(ziarno_kolor);
        g.drawString(ziarno_tekst + " kupil "+ ziarno_wartosc + " jablek", 70, 40);
    }


    public void setZiarno_wartosc(int nowa_wartosc) throws PropertyVetoException
    {
        int stara_wartosc = ziarno_wartosc;
        vetoable_support.fireVetoableChange("ziarno_wartosc",stara_wartosc,nowa_wartosc);
        ziarno_wartosc = nowa_wartosc;
        change_support.firePropertyChange("ziarno_wartosc",stara_wartosc,nowa_wartosc);
    }

    public int getZiarno_wartosc()
    {
        return ziarno_wartosc;
    }

    public void setZiarno_tekst(String newString)
    {
        ziarno_tekst = newString;
    }

    public String getZiarno_tekst()
    {
        return ziarno_tekst;
    }

    public void setZiarno_kolor(Color newColor)
    {
        Color oldColor = ziarno_kolor;
        ziarno_kolor = newColor;
        change_support.firePropertyChange("ziarno_kolor", oldColor, newColor);
    }

    public Color getZiarno_kolor()
    {
        return ziarno_kolor;
    }

    public synchronized void addPropertyChangeListener(PropertyChangeListener l)
    {
        change_support.addPropertyChangeListener(l);
    }

    public synchronized void removePropertyChangeListener(PropertyChangeListener l)
    {
        change_support.removePropertyChangeListener(l);
    }

    public synchronized void addVetoableChangeListener(VetoableChangeListener l)
    {
        vetoable_support.addVetoableChangeListener(l);
    }

    public synchronized void removeVetoableChangeListener(VetoableChangeListener l)
    {
        vetoable_support.removeVetoableChangeListener(l);
    }

    public synchronized void addChangeListener(ChangeListener l)
    {
        listener_list.add(ChangeListener.class, l);
    }

    public synchronized void removeChangeListener(ChangeListener l)
    {
        listener_list.remove(ChangeListener.class, l);
    }


    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeObject(new Dimension(200, 200));
        out.writeInt(ziarno_wartosc);
        out.writeObject(ziarno_tekst);
        out.writeObject(ziarno_kolor);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        try
        {
            setZiarno_wartosc(in.readInt());
        } catch (PropertyVetoException pve) {
            System.out.println("Value vetoed...");
        }
        setZiarno_tekst((String) in.readObject());
        setZiarno_kolor((Color) in.readObject());
    }
}