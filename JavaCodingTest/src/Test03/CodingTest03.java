package Test03;
/** 배를 타고 섬을 건너는 시간 구하기
 * (1) 한 배에 탈 수 있는 인원은 정시에는 25명, 이후에는 10분 마다 10명씩 탈 수 있음
 * (2) 배는 매일 9시부터 21시 전까지(21시는 포함하지 않음) 10분 단위로 들어옴
 * (3) 전체 인원은 14,000,605명 임
 * (4) 1월은 1024일, 2월은 512일, 3월은 256일, 4월은 128일, 5월은 64일, 6월은 32일, 7월은 16일, 8월은 8일, 9월은 4일, 10월은 2일
 * (5) 현재 날짜는 2020년 1월 1일
 * (6) 배에 타는 순간 화장실이 급하여 화장실에 갔으며, 이로 인해 현재 시간의 '분'에 해당하는 만큼 시간이 지연됨
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class CodingTest03 {

    public static void main(String[] args) {
        int numOfWaitingPeople = 14000605;  // number of waiting people ahead of us
        solution(numOfWaitingPeople);
    }

    private static void solution(int numOfWaitingPeople) {
        int[] numOfLoadPeoplePerTenMinute = {25, 15, 15, 15, 15, 15};
        int numOfLoadPeoplePerHour = Arrays.stream(numOfLoadPeoplePerTenMinute).sum();
        int numOfLoadPeoplePerOneDay = (21 - 9) * numOfLoadPeoplePerHour;

        ArrayList<Integer> numOfLoadPeoplePerMonth = new ArrayList<Integer>();
        for(int i = 10; i > 0; i--){
            int numOfDaysInMonth = (int) Math.pow(2, i);    // number of days in i-th month
            numOfLoadPeoplePerMonth.add(numOfDaysInMonth * numOfLoadPeoplePerOneDay);
        }
        int numOfLoadPeoplePerYear = numOfLoadPeoplePerMonth.stream().mapToInt(a->a).sum();

        // Derive the year that you can ride a ship
        int year = 2020;
        while(numOfWaitingPeople > numOfLoadPeoplePerYear){
            numOfWaitingPeople -= numOfLoadPeoplePerYear;
            year++;
        }

        // Derive the year that you can ride a ship
        int thisMonth = 1;
        while(numOfWaitingPeople > numOfLoadPeoplePerMonth.get(thisMonth-1)){
            numOfWaitingPeople -= numOfLoadPeoplePerMonth.get(thisMonth-1);
            thisMonth++;
        }

        // Derive the year that you can ride a ship
        int today = 1;
        while(numOfWaitingPeople > numOfLoadPeoplePerOneDay){
            numOfWaitingPeople -= numOfLoadPeoplePerOneDay;
            today++;
        }

        // Derive the hour that you can ride a ship
        int hour = 9;
        while(numOfWaitingPeople > numOfLoadPeoplePerHour){
            numOfWaitingPeople -= numOfLoadPeoplePerHour;
            hour++;
        }

        // Derive the minutes that you can ride a ship
        int minuteIndex = 0, minute = 0;
        while(numOfWaitingPeople > numOfLoadPeoplePerTenMinute[minuteIndex]){
            numOfWaitingPeople -= numOfLoadPeoplePerTenMinute[minuteIndex];
            minuteIndex++;
        }
        minute = 10 * minuteIndex;

        // time to used for toilet
        Calendar currentTime = Calendar.getInstance();
        minute = currentTime.get(Calendar.MINUTE) + minute;
        if(minute > 60){
            minute = minute -60;
            hour++;
        }
        System.out.println(year + "년, " + thisMonth + "월, " + today + "일, " + hour +"시, " + minute + "분");
    }
}
