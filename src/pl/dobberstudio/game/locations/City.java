package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.locations.city.MapLocation;

public class City extends Location
{
    public MapLocation[] locations = new MapLocation[12];

    public City(GameManager gm, String path)
    {
        super(gm, path);
        int c = 19;
             locations[0] = new MapLocation(gm, "house.png", c * 1, c * 27);
             locations[0].setOnClick(new Runnable() {
                @Override
                public void run()
                {
                    System.out.println("house");
                }
            });
             locations[1] = new MapLocation(gm, "toad.png", c * 11, c * 25);
             locations[1].setOnClick(new Runnable() {
                 @Override
                 public void run() {
                     System.out.println("toad");
                 }
             });
             locations[2] = new MapLocation(gm, "clothes.png", c * 10, c * 9);
        locations[2].setOnClick(new Runnable() {
            @Override
            public void run() {
                System.out.println("clothes");
            }
        });
             locations[3] = new MapLocation(gm, "jeweller.png", c * 14, c * 2);
        locations[3].setOnClick(new Runnable() {
            @Override
            public void run() {
                System.out.println("jeweller");
            }
        });
             locations[4] = new MapLocation(gm, "restaurant.png", c * 26, c * 4);
        locations[4].setOnClick(new Runnable() {
            @Override
            public void run() {
                System.out.println("restaurant");
            }
        });
             locations[5] = new MapLocation(gm, "florist.png", c * 40, c * 4);
        locations[5].setOnClick(new Runnable() {
            @Override
            public void run() {
                System.out.println("florist");
            }
        });
             locations[6] = new MapLocation(gm, "park.png", c * 26, c * 15);
        locations[6].setOnClick(new Runnable() {
            @Override
            public void run() {
                System.out.println("park");
            }
        });
             locations[7] = new MapLocation(gm, "work.png", c * 40, c * 14);
        locations[7].setOnClick(new Runnable() {
            @Override
            public void run() {
                System.out.println("work");
            }
        });
             locations[8] = new MapLocation(gm, "pub.png", c * 43, c * 29);
        locations[8].setOnClick(new Runnable() {
            @Override
            public void run() {
                System.out.println("pub");
            }
        });
             locations[9] = new MapLocation(gm, "orlen.png", c * 56, c * 2);
        locations[9].setOnClick(new Runnable() {
            @Override
            public void run() {
                System.out.println("orlen");
            }
        });
             locations[10] = new MapLocation(gm, "cinema.png", c * 54, c * 14);
        locations[10].setOnClick(new Runnable() {
            @Override
            public void run() {
                System.out.println("cinema");
            }
        });
             locations[11] = new MapLocation(gm, "gym.png", c * 54, c * 27);
        locations[11].setOnClick(new Runnable() {
            @Override
            public void run() {
                System.out.println("gym");
            }
        });
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {
        for(MapLocation m : locations)
        {
            m.isClicked(gc);
        }
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        super.render(gc, renderer);
        for(MapLocation m : locations)
        {
            renderer.drawImage(m.getIcon(), (int)m.x, (int)m.y);
        }
    }
}