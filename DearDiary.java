import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DearDiary {
    public static void main(String[] args) {
        DearDiary application = new DearDiary();
        application.runApplication();
    }

    private void runApplication() {
        List<DiaryEntry> diaryEntries = new ArrayList<>();
        System.out.println("Welcome back Tamila, please tell me how you feel...");
        System.out.println("Lets start with the number of thoughts you have in your mind... "
                + "Please enter positive integer for this");
        Scanner scanner = new Scanner(System.in);
        int numberOfEntries = scanner.nextInt();

        for(int i = 0; i < numberOfEntries; i++) {
            DiaryEntry diaryEntry = new DiaryEntry();
            System.out.println("Now tell me your mood...");
            diaryEntry.setMood(scanner.next());
            System.out.println("Now tell me how you feel...");
            diaryEntry.setDiaryText(scanner.next());
            diaryEntries.add(diaryEntry);
            System.out.println("Entry persisted");
        }

        int moodOMeter = 0;
        System.out.println("Telling you your thoughts again...");
        for(DiaryEntry diaryEntry : diaryEntries) {
            System.out.println(diaryEntry);
            if(diaryEntry.getMood().equalsIgnoreCase("Good")) {
                moodOMeter++;
            } else if(diaryEntry.getMood().equalsIgnoreCase("Bad"))
            {
                moodOMeter--;
        }
    }

    System.out.println("Performing mood analysis...");
    if(moodOMeter > 0) {
        System.out.println("I am glad you feel good Tamila");
    } else if(moodOMeter < 0) {
        System.out.println("Bad mood happens, but you have to stay strong...");
        } else {
            System.out.println("No mood is always a food for thought");
    }
        }

        private class DiaryEntry {
            private String diaryText;
            private String mood;
            public void setDiaryText(String diaryText) {
                if(diaryText == null || diaryText.isEmpty()) {
                    throw new IllegalArgumentException("Sorry, can't handle empty/null text");
                }
                this.diaryText = diaryText;
            }
            public String getDiaryText() {
                return diaryText;
            }
            public void setMood(String mood) {
                if(!mood.equalsIgnoreCase("Good") &&
                        !mood.equalsIgnoreCase("Bad")) {
                    throw new IllegalArgumentException("Sorry, you have to tell me how you feel");
                }
                this.mood = mood;
            }
            public String getMood() {
                return mood;
            }
            @Override
            public String toString() {
                return "Mood:" + this.mood + " Thought: " +
                        this.diaryText;
            }
        }
    }
