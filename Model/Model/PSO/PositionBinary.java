package Model.Model.PSO;

import Model.Model.Actions.*;

import java.util.ArrayList;
import java.util.List;

public class PositionBinary {

    public static long getPosition(List<Action> actions) {
        StringBuilder sb = new StringBuilder();
        for (Action action : actions) {
            sb.append(action.getBinaryCode());
        }
        char[] b = sb.toString().toCharArray();
        int p = 1;
        long r = 0;
        for(int i = b.length-1; i > -1; i--){
            r += Integer.parseInt(String.valueOf(b[i]))*p;
            p *= 2;
        }
        return r;
       // return Long.parseUnsignedLong(sb.toString(), 2);
    }

    public static List<Action> getActions(long position) {
        List<Action> actions = new ArrayList<>();

        String res = Long.toBinaryString(position);
        if (res.length() % 2 != 0)
            res = "0" + res;
        Action action = new ActionVide();
        int n = res.length() % 2 == 0 ? res.length() : res.length() - 1;

        for (int i = 0; i < n; i += 2) {

            switch (res.substring(i, i + 2)) {
                case "00":
                    action = new Up();
                    break;
                case "01":
                    action = new Down();
                    break;
                case "10":
                    action = new Left();
                    break;
                case "11":
                    action = new Right();
                    break;
            }
            actions.add(action);
        }

        return actions;

    }
}
