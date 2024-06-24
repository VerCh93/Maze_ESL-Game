import java.util.*;

public class PastVerbs implements ITask {
    public String welcome() {
        return ITask.super.welcome();
    } //prints welcome message

    public void taskInstructions() throws InterruptedException { //prints task instructions
        try {
            Thread.sleep(3000);
            System.out.println("I'm sure you know that there are three different ways to pronounce -ed in the past tense.\nIn this task you must decide if the verbs belongs in the 't', 'd', or 'id' group.\nGood luck!\n");
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.err.println("Thread was interrupted");
        }
    }

    public boolean doTask() throws InterruptedException {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        String[] dVerbs = {"played", "moved", "loved", "cried", "used", "lived", "opened"}; //verb arrays based on pronunciation
        String[] tVerbs = {"cooked", "washed", "watched", "helped", "laughed", "danced"};
        String[] idVerbs = {"wanted", "decided", "hated", "waited", "needed", "started"};

        Map<String, String> verbsMap = new HashMap<>(); //hashmap for verbs from arrays with key (key being how verb is pronounced)

        for (String verbD : dVerbs) { //adds verbs to hashmap
            verbsMap.put(verbD, "d");
        }
        for (String verbT : tVerbs) {
            verbsMap.put(verbT, "t");
        }
        for (String verbId : idVerbs) {
            verbsMap.put(verbId, "id");
        }

        List<String> allVerbs = new ArrayList<>(); //new arrays for all verbs put together
        allVerbs.addAll(Arrays.asList(dVerbs)); ///adds all verbs to new array
        allVerbs.addAll(Arrays.asList(idVerbs));
        allVerbs.addAll(Arrays.asList(tVerbs));

        System.out.println("Decide on the verb's group (type d, t, or id)\n"); //answer prompt

        for (int i = 0; i < 6; i++) {
            String randomVerb = allVerbs.get(random.nextInt(allVerbs.size())); //randomly chooses 6 verbs from array
            System.out.println(randomVerb); //prints verb
            String answer = sc.nextLine().trim().toLowerCase(); //answer input

            if (answer.equals(verbsMap.get(randomVerb))) { //compares answer to key-verb match in hashmap
                System.out.println(passMessage());

            } else {
                System.out.println(failMessage());
                return false;
            }
        }
        return true;
    }
}
