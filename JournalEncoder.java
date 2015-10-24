import java.util.ArrayList;
import java.util.Date;
import java.io.*;
import java.util.Scanner;

public class JournalEncoder {

    public static void encodeJournal(Journal j, String filename) {
        try {
        File file = new File(System.getProperty("user.dir") + "/" + filename);
        if (!file.exists())
            file.createNewFile();

        Writer writer = new FileWriter(file.getAbsoluteFile());

        writer.write("owner=\n" + j.getOwner());
        writer.write("\nentries=");
        for (Entry e : j.getEntries()) {
            writer.write("\nentry=");
            writer.write("\nid=\n" + e.getId());
            // do not write the data here we can look it up
            writer.write("\nuserRating=\n" + e.getUserRating());
            writer.write("\nuserReview=\n" + e.getUserReview());
            writer.write("\ntimesSeen=\n" + e.getTimesSeen());
            writer.write("\ndateSeen=\n" + e.getDateSeen().getTime());
            writer.write("\ndateEntered=\n" + e.getDateEntered().getTime());
            writer.write("\nentryDescription=\n" + e.getEntryDescription());
            writer.write("\nlocation=\n" + e.getLocation()[0] + "\n" + e.getLocation()[1]);
        }
        } catch (IOException e) {throw new IllegalArgumentException();}
    }

    public static Journal decodeJournal(String filename) {
        Scanner file = new Scanner(filename);
        file.nextLine();
        String owner = file.nextLine();
        file.nextLine();
        ArrayList<Entry> entries = new ArrayList<Entry>();
        while (file.hasNextLine()) {
            file.nextLine();
            String id = file.nextLine();
            file.nextLine();
			double userRating = Double.parseDouble(file.nextLine());
			file.nextLine();
			String userReview = file.nextLine();
			file.nextLine();
			int timesSeen = Integer.parseInt(file.nextLine());
			file.nextLine();
			long dateSeen = Long.parseLong(file.nextLine());
			file.nextLine();
			long dateEntered = Long.parseLong(file.nextLine());
			file.nextLine();
			String entryDescription = file.nextLine();
			file.nextLine();
			int[] location = new int[2];
			location[0] = Integer.parseInt(file.nextLine());
			location[1] = Integer.parseInt(file.nextLine());
			
            Entry e = new Entry(Database.getById(id));
            e.setId(id);
            e.setUserRating(userRating);
            e.setUserReview(userReview);
            e.setTimesSeen(timesSeen);
            e.setDateSeen(dateSeen);
            e.setDateEntered(dateEntered);
            e.setEntryDescription(entryDescription);
            e.setLocation(location);

            entries.add(e);
        }

        Journal j = new Journal(owner);
        for (Entry e : entries)
            j.addEntry(e);
        return j;
    }
}
