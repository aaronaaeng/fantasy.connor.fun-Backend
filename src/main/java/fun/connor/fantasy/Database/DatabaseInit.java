package fun.connor.fantasy.Database;

import fun.connor.fantasy.Athlete.Athlete;
import fun.connor.fantasy.Athlete.AthleteName;
import fun.connor.fantasy.Athlete.AthleteType;
import fun.connor.fantasy.Statistics.BowlerData;
import fun.connor.fantasy.Statistics.BowlerStatistics;

import java.util.Random;
import java.util.UUID;

/**
 * This class initializes the database with filler athletes.
 */
public class DatabaseInit {
    public static void initializeAthletes(DatabaseAccessObject databaseAccessObject) {
        for (int i = 0; i < 5; i++) {
            BowlerData bowlerData = new BowlerData(randDouble(0, 10), randDouble(0, 1),
                    randDouble(0, 1), randDouble(7, 18),
                    randDouble(0, 1), 20);
            BowlerStatistics bowlerStatistics = new BowlerStatistics();
            bowlerStatistics.addGame(bowlerData);
            Athlete athlete = new Athlete(UUID.randomUUID(), new AthleteName("First", "Last"), AthleteType.BOWLER, bowlerStatistics);
            databaseAccessObject.save(athlete);
        }
    }

    private static Double randDouble(Integer rangeMin, Integer rangeMax)
    {
        Random r = new Random();
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }
}
