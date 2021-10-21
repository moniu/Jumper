package Engine;

public class RenderThread implements Runnable{
    private Game game;

    public RenderThread(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while(true){
            try {
                game.renderEngine.render();
            }
            catch (Exception e) {
                //e.printStackTrace(); //PRZEPRASZAM
            }
        }
    }
        
}
