import { describe, expect, it, test, type Test } from "bun:test";
import { getLastMonthsSundays } from "../src/last-sunday-calculator";

interface TestCase {
  description: string;
  year: number;
  expectedResult: string[];
}

const testCases: TestCase[] = [
  {
    description: "Should provide list of valid dates for 2013",
    year: 2013,
    expectedResult: [
      "2013-01-27",
      "2013-02-24",
      "2013-03-31",
      "2013-04-28",
      "2013-05-26",
      "2013-06-30",
      "2013-07-28",
      "2013-08-25",
      "2013-09-29",
      "2013-10-27",
      "2013-11-24",
      "2013-12-29",
    ],
  },
  {
    description: "Should provide list of valid dates for 2013",
    year: 2014,
    expectedResult: [
      "2014-01-26",
      "2014-02-23",
      "2014-03-30",
      "2014-04-27",
      "2014-05-25",
      "2014-06-29",
      "2014-07-27",
      "2014-08-31",
      "2014-09-28",
      "2014-10-26",
      "2014-11-30",
      "2014-12-28",
    ],
  },
];

describe("Last sunday of each month for a given year", () => {
  testCases.forEach((testCase) => {
    it(testCase.description, () => {
      const actualResult = getLastMonthsSundays(testCase.year);
      expect(testCase.expectedResult).toEqual(actualResult);
    });
  });
});
