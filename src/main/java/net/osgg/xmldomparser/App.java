package net.osgg.xmldomparser;

/**
 * Andres Gavino 6600
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DomParser dp = new DomParser("poblacion.xml");
        try {
			dp.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
