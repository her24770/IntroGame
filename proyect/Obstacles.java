import greenfoot.*;  

public class Obstacles extends Actor
{
    public Obstacles()
    {
        // Define el tamaño y apariencia del obstáculo
        GreenfootImage image = new GreenfootImage(50, 50); // Tamaño del bloque (50x50 píxeles)
        image.setColor(Color.GRAY); // Color del bloque
        image.fill(); // Rellena el bloque con el color especificado
        setImage(image); // Establece la imagen del obstáculo
    }
    public void act()
    
    {
        // Add your action code here.
    }
}
