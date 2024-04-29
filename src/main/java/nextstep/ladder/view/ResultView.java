package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.UserNames;

import java.util.List;

public class ResultView {
	private final static String GAP = "     ";
	private final static String LINE = "-----";
	private final static String LADDER = "|";
	private final static String LADDER_FORMAT = "%6s";
	private static final String QUIT_RESULT_VIEW = "q";
	private static final String ALL_RESULT_VIEW = "all";


	public static void printNames(UserNames userNames) {
		System.out.println("사디리 결과");
		userNames.getNames().stream().map(name -> String.format(LADDER_FORMAT, name)).forEach(System.out::print);
		System.out.println();
	}

	public static void printLadderBoard(Ladder ladder) {
		ladder.getLadder().forEach(line -> {
			printGap(false);
			printRow(line);
			printLadder();
			System.out.println();
		});
	}

	private static void printRow(Line line) {
		line.pointToBoolean().forEach(point -> {
			printLadder();
			printLine(point);
			printGap(point);
		});
	}

	private static void printLadder() {
		System.out.print(LADDER);
	}

	private static void printLine(Boolean point) {
		if (point) {
			System.out.print(LINE);
		}
	}

	private static void printGap(Boolean point) {
		if (!point) {
			System.out.print(GAP);
		}
	}

	public static void printResultSinglePerson(String result) {
		System.out.println("실행 결과");
		System.out.println(result);
	}

	public static void printResultPerson(LadderGameResult results) {
		System.out.println("실행 결과");
		System.out.println(results.toString());
	}

	public static void printLadderGameResult(List<String> executionResult) {
		executionResult.stream().map(result -> String.format(LADDER_FORMAT, result)).forEach(System.out::print);
		System.out.println();
	}

	public static void printLadderGameResultPerson(LadderGameResult result) {
		while (true) {
			String interestedPerson = InputView.inputInterestedPerson();
			if (interestedPerson.equals(QUIT_RESULT_VIEW)) {
				return;
			}
			if (interestedPerson.equals(ALL_RESULT_VIEW)) {
				printResultPerson(result);
			} else {
				printResultSinglePerson(result.getSingleResult(interestedPerson));
			}
		}
	}

}
