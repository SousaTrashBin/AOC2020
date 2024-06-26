package day6;

import utils.Day;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day6 extends Day {
    private final List<Group> groupList;

    private static int StringToInt(String string) {
        if(string.isEmpty()) return 0;
        return Integer.parseInt(String.valueOf(string.charAt(string.length()-1)))
                + StringToInt(string.substring(0,string.length()-1)) * 10;
    }

    public static void main(String[] args) {
        System.out.println(StringToInt("12345"));
    }
    public Day6() throws IOException {
        super(6);
        groupList = Arrays.stream(
            Files.readString(Path.of(getFile())).split("\n\n")
        )
            .map(Group::new)
            .toList();

        Comparator.comparing(String::length)
                .thenComparing(String::hashCode);
    }

    @Override
    public String Part1() {
        return groupList
            .stream()
            .map(Group::getNumberOfQuestions)
            .reduce(Integer::sum)
            .get()
            .toString();
    }

    @Override
    public String Part2() {
        return groupList
            .stream()
            .map(Group::getNumberOfEveryoneYes)
            .reduce(Integer::sum)
            .get()
            .toString();
    }
}
