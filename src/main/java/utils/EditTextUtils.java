package utils;

public class EditTextUtils {

    private static StringBuilder sumOnline;

    private static StringBuilder sumInGame;

    public static StringBuilder getSumInGames() {
        return sumInGame;
    }

    public static StringBuilder getSumOnline() {
        return sumOnline;
    }

    public static String[] splitTextForPeopleOnlineAndPeopleInGames(String textWhichYouNeedToCreated, String textWhichYouNeedToDeleted) {
        return textWhichYouNeedToCreated.split(textWhichYouNeedToDeleted);
    }

    public static int createdFromStringIntoInt(StringBuilder elementForCreateIntoInt) {
        return Integer.parseInt(elementForCreateIntoInt.toString().trim());
    }

    public static StringBuilder sumOfPlayersOnline() {
        return sumOnline = new StringBuilder();
    }

    public static StringBuilder sumOfPlayersInGames() {
        return sumInGame = new StringBuilder();
    }

}
