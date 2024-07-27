package Old.Contest;

import java.util.Arrays;

public class contest2286 {
    class BookMyShow {
        int[][] map;

        public BookMyShow(int n, int m) {
            map = new int[n][m];
        }

        public int[] gather(int k, int maxRow) {
            for (int i = 0; i <= maxRow; i++) {
                int[] now = map[i];
                int l = 0;
                int r = 0;
                while (l <= now.length - k && r < now.length ) {
                    if (r - l + 1 == k) {
                        for (int j = l; j <= r; j++) {
                            map[i][j] = 1;
                        }
                        return new int[]{i, l};
                    }
                    if (now[r] == 1)
                        l = r + 1;
                    r++;
                }
            }
            return new int[]{};
        }

        public boolean scatter(int k, int maxRow) {
            int[][] map_ = this.map;
            for (int i = 0; i <= maxRow; i++) {
                int[] now = map_[i];
                int sum = Arrays.stream(now).sum();
                if (sum < map_[0].length) {
                    int dis = map_[0].length - sum;
                    if (k - dis > 0) {
                        Arrays.fill(now, 1);
                        map_[i] = now;
                        k = k - dis;
                    }
                    if (k - dis == 0) {
                        Arrays.fill(now, 1);
                        map_[i] = now;
                        this.map = map_;
                        return true;
                    }
                    if (k - dis < 0) {
                        for (int j = 0; j < now.length; j++) {
                            if (now[j] == 0) {
                                now[j] = 1;
                                k--;
                            }
                            if (k == 0) break;
                        }
                        map_[i] = now;
                        this.map = map_;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        contest2286 contest = new contest2286();
    }
}
