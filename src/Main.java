public class Main {
    public static void main(String args[]){
        CellPanel cellPanel = new CellPanel(100,100);
        GameGUI Game = new GameGUI("生命游戏",cellPanel);
        Game.InitGameGUI();
        return;
    }
}
