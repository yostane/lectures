// date.getDay() -> 0 dimcahe et 6 samedi
export function getLastMonthsSundays(year: number): string[] {
  const result: string[] = [];
  for (let index = 0; index < 12; index++) {
    const lastSundayOfMonth = new Date(Date.UTC(year, index + 1));
    lastSundayOfMonth.setUTCHours(12, 0, 0, 0);
    while (lastSundayOfMonth.getUTCDay() !== 0) {
      lastSundayOfMonth.setUTCDate(lastSundayOfMonth.getUTCDate() - 1);
    }
    const paddedMonth = (index + 1).toString().padStart(2, "0");
    const dateString = `${year}-${paddedMonth}-${lastSundayOfMonth.getUTCDate()}`;
    console.log(dateString);
    result.push(dateString);
  }
  return result;
}
