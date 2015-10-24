public class JournalEncoder {

    public static void encodeJournal(Journal j, String filename) {
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
        writer.write("owner=\n" + j.getOwner);
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
        writer.write("done");
    }

    public static Journal decodeJournal(String filename) {
        Scanner file = new Scanner(filename);
        file.nextLine();
        String owner = file.nextLine();
        file.nextLine();
        boolean done = false;
        ArrayList<Entry> entries = new ArrayList<Entry>();
        while (!done) {
            if (file.nextLine().equals("done")) {
                break;
            }
            String id = file.nextLine();
            file.nextLine();
			double userRating = file.nextLine();
			file.nextLine();
			String userReview = file.nextLine();
			file.nextLine();
			int timesSeen = file.nextLine();
			file.nextLine();
			int dateSeen = file.nextLine();
			file.nextLine();
			int dateEntered = file.nextLine();
			file.nextLine();
			String entryDescription = file.nextLine();
			file.nextLine();
			int[] location = new int[2];
			location[0] = file.nextLine();
			location[1] = file.nextLine();
			
            Entry e = new Entry(Database.getById(id));
            e.setId(id);
            e.setUserRating(userRating);
            e.setUserReview(userReview);
            e.setTimesSeen(timesSeen);
            e.setDateSeen(new Date(dateSeen));
            e.setDateEntered(new Date(dateEntered));
            e.setEntryDescription(entryDescription);
            e.setLocation(location);

            entries.append(e);
        }

        Journal j = new Journal(owner);
        for (Entry e : entries)
            j.addEntry(e);
        return j;
    }
}
