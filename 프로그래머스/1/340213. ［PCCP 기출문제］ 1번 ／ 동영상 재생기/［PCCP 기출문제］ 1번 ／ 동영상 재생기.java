class Solution {
public int changeTime(String time){
        String[] split = time.split(":");
        int[] intTime = new int[2];
        for(int i = 0; i < split.length; i++){
            intTime[i] = Integer.parseInt(split[i]);
        }
        int result = intTime[0] * 60 + intTime[1];

        return result;
    }

    public boolean isOpening(int time, int start, int end){
        boolean result = false;
        if(time >= start && time <= end) result = true;

        return result;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        // 분 초
        int posTime = changeTime(pos);
        int start = changeTime(op_start);
        int end = changeTime(op_end);
        int total = changeTime(video_len);

        for(int i = 0; i < commands.length; i++){
            String command = commands[i];

            if(command.equals("prev")){
                // 오프닝 구간임?
                if(isOpening(posTime, start, end)){
                    // 오프닝 끝 구간으로 이동
                    posTime = end;
                    // 10초 전으로 이동
                    posTime = Math.max(0, posTime - 10);
                    // 다시 오프닝 구간인지... 체크
                    if(isOpening(posTime, start, end)) posTime = end;
                }else{ //오프닝 구간이 아닐 경우
                    posTime = Math.max(0, posTime - 10);
                    if(isOpening(posTime, start,end)) posTime = end;
                }
            }else{ // "next"
                if(isOpening(posTime, start, end)) {
                    posTime = end;
                    // 10초 후로 이동
                    posTime = Math.min(total, posTime + 10);
                }else{
                    posTime = Math.min(total, posTime + 10);
                    // 다시... 오프닝 구간이면?
                    if(isOpening(posTime, start, end)) posTime = end;
                }
            }
        }
        int min = posTime / 60;
        int sec = posTime % 60;

        String answer = String.format("%02d:%02d", min, sec);
        return answer;
    }
}