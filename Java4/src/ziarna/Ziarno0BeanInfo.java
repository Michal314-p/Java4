package ziarna;

import java.awt.*;
import java.beans.*;


public class Ziarno0BeanInfo extends SimpleBeanInfo
{
    
    public Image getIcon(int iconKind)
    {
        Image obrazek = null;
        obrazek = loadImage("jablko.jpg");
        return obrazek;
    }

    public BeanDescriptor getBeanDescriptor ()
    {
        BeanDescriptor bd = new BeanDescriptor(Ziarno0.class);
        bd.setDisplayName("Przykladowe ziarno z wszystkimi wlasciwosciami");
        return bd;
    }

    public PropertyDescriptor[] getPropertyDescriptors()
    {
        try {
            PropertyDescriptor wartosc = new PropertyDescriptor("ziarno_wartosc", Ziarno0.class);
            PropertyDescriptor kolor = new PropertyDescriptor("ziarno_kolor", Ziarno0.class);
            PropertyDescriptor tekst = new PropertyDescriptor("ziarno_tekst", Ziarno0.class);

            PropertyDescriptor rv[] = {wartosc, kolor, tekst};
            return rv;
        } catch (IntrospectionException e)
        {
            throw new Error(e.toString());
        }
    }

}
