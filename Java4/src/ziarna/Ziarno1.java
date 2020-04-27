package ziarna;

import java.awt.*;
import java.beans.*;

public class Ziarno1 implements PropertyChangeListener,VetoableChangeListener
{

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent)
    {
        if(propertyChangeEvent.getOldValue() instanceof Color)
        {
            Color druk = (Color) propertyChangeEvent.getNewValue();
            System.out.println("Zmiana koloru na: " + druk);
        }

        if(propertyChangeEvent.getOldValue() instanceof Integer)
        {
            int druk = (Integer) propertyChangeEvent.getNewValue();
            System.out.println("Zmiana wartosci na: " + druk);
        }
    }

    @Override
    public void vetoableChange(PropertyChangeEvent propertyChangeEvent) throws PropertyVetoException
    {
        Integer nowa_wartosc = (Integer) propertyChangeEvent.getNewValue();
        Integer wartosc = nowa_wartosc;
        if(wartosc==0)
        {
            throw new PropertyVetoException("Nie mozna kupic zerowej ilosci jablek", propertyChangeEvent);
        }
    }
}
