import greenfoot.*;  

public class personaje extends Actor
{
    private int speed = 5; // Velocidad de movimiento del personaje

    public void act()
    {
        movePlayer();
        checkCollision();
    }

    private void movePlayer()
    {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + speed, getY());
        }
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + speed);
        }
    }

    private void checkCollision()
    {
        Actor obstacle = getOneIntersectingObject(Obstacles.class);
        if (obstacle != null) {
            // Si el personaje colisiona con un obstáculo, revertir el movimiento
            if (Greenfoot.isKeyDown("left")) {
                setLocation(getX() + speed, getY());
            }
            if (Greenfoot.isKeyDown("right")) {
                setLocation(getX() - speed, getY());
            }
            if (Greenfoot.isKeyDown("up")) {
                setLocation(getX(), getY() + speed);
            }
            if (Greenfoot.isKeyDown("down")) {
                setLocation(getX(), getY() - speed);
            }
        }
    }
}

