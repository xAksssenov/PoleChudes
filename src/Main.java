import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final char Const_hidden_letter = '*';

        char[] originalWord;
        String question;

        char[] guessWord;

        boolean isGuessed = false;

        System.out.print("Введите загадку: ");
        question = scanner.nextLine();

        System.out.print("Введите загаданное слово: ");
        originalWord = scanner.next().toCharArray();

        guessWord = new char[originalWord.length];
        for (int i = 0; i < guessWord.length; i++) {
            guessWord[i] = Const_hidden_letter;
        }

        do {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }

            System.out.println();
            System.out.println(question);
            System.out.println("Отгаданное слово");

            for (int i = 0; i < guessWord.length; i++) {
                System.out.print(guessWord[i] + " ");
            }

            System.out.println();
            System.out.println("Введите предполагаемую букву или слово целиком: ");
            String inputLine = scanner.nextLine();

            if (inputLine.length() == 1) {

                char inputLetter = inputLine.charAt(0);

                boolean temp = false;
                for (int i = 0; i < originalWord.length; i++) {
                    if (originalWord[i] == inputLetter) {
                        guessWord[i] = inputLetter;
                        temp = true;
                    }
                }

                if (temp == true) {
                    System.out.println("Одна из букв угадана");
                } else {
                    System.out.println("Такой буквы нет, попробуйте ещё раз");
                }

                isGuessed = true;
                for (int i = 0; i < guessWord.length; i++) {
                    if (guessWord[i] == Const_hidden_letter) {
                        isGuessed = false;
                        break;
                    }
                }
            } else {
                isGuessed = true;

                char[] inputWord = inputLine.toCharArray();

                if (originalWord.length != inputWord.length) {
                    isGuessed = false;
                } else {
                    for (int i = 0; i < originalWord.length; i++) {
                        if (originalWord[i] != inputWord[i]) {
                            isGuessed = false;
                        }
                    }
                }
                if (isGuessed == true) {
                    for (int i = 0; i < inputWord.length; i++) {
                        guessWord[i] = inputWord[i];
                    }
                }
            }
        } while (isGuessed == false);

        System.out.println("Игра завершена, вы угадали слово:");
        for (int i = 0; i < guessWord.length; i++) {
            System.out.print(guessWord[i]);
        }
    }
}