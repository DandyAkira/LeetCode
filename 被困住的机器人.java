import java.util.ArrayList;
class RobotInLoop {
    public static boolean isRobotBounded(String instructions) {
        ArrayList<String> directions = new ArrayList<>();
        directions.add("North");
        directions.add("East");
        directions.add("South");
        directions.add("West");
        ArrayList<Integer[]> posArray = new ArrayList<>();
        int head = 0;
        Integer[] pos = new Integer[2];
        pos[0] = 0;
        pos[1] = 0;
        int i = 0;
        while(i<instructions.length()){
            switch (instructions.charAt(i)){
                case 'G':
                    switch (head){
                        case 0:
                            pos[1] = pos[1]+1;
                            break;
                        case 1:
                            pos[0] = pos[0]+1;
                            break;
                        case 2:
                            pos[1] = pos[1]-1;
                            break;
                        case 3:
                            pos[0] = pos[0]-1;
                            break;
                    }
                    break;
                case 'L':
                    if(head == 0){head = 3;}
                    else{head--;}
                    break;
                case'R':
                    if(head == 3){head = 0;}
                    else{head++;}
                    break;
            }
            i++;
        }
        return (pos[0] == 0 && pos[1] == 0) || head != 0;
    }

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
    }
}

