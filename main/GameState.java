package main;

public enum GameState {
    PLAYING, MENU, SETTINGS, EDIT, GAME_OVER;

    private static GameState gameState = MENU;

    public static void setGameState(GameState state) {
        gameState = state;
    }

    public static GameState getGameState() {
        return gameState;
    }
}