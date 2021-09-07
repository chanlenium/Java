package Test02;

import java.util.ArrayList;

/** <징검다리>
 * (1) 각 돌들이 얼마나 버틸 수 있는지 배열로 주어짐
 * (2) 각 dog의 정보가 객체 배열로 주어짐
 * (3) 돌에 dog이 착지할 때 돌의 내구도는 dog의 몸무게 만큼 줄어듦
 * (4) dog의 점프력은 각자 다르며, 점프력 만큼 점프하여 착지
 * (5) dog는 순서대로 다리를 건넘
 * */
public class CodingTest02 {
    public static void main(String[] args) {
        int[] stoneRobustness = {1, 2, 1, 4};
        Dog[] dogArray = {
                new Dog("루비독", "95년생", 3, 4),
                new Dog("피치독", "95년생", 3, 4),
                new Dog("씨독", "72년생", 2, 1),
                new Dog("코볼독", "59년생", 1, 1)
        };
        solution(stoneRobustness, dogArray);
    }

    private static void solution(int[] stoneRobustness, Dog[] dogArray) {
        // Create ArrayList object to store survived dog name
        ArrayList<String> survivedDogName = new ArrayList<String>();

        // Loop all dogs in array
        for(Dog dog : dogArray){
            int dogPosition = dog.jumpAbility - 1;  // dog position
            stoneRobustness[dogPosition] -= dog.weight; // Decrease stone robustness by dog weight
            Boolean isFail = false; // flag to indicate whether a current dog fail to pass the river

            // loop while a current dog is passing the river
            while(!isFail && dogPosition < stoneRobustness.length){
                if(stoneRobustness[dogPosition] < 0){   // stone cannot hold up dog's weight
                    isFail = true;
                }else{
                    dogPosition += dog.jumpAbility; // dog jump to next position
                }
            }

            // Check whether the dog succeed to pass the river or fail in the middle
            if(!isFail){
                // Add the dog's name to the list only if the dog succeeded to paa the river
                survivedDogName.add(dog.name);
            }
        }
        System.out.println("Survived Dog : " + survivedDogName);
    }
}
