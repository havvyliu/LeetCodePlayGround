class SnakeGame {

  int[] pos = new int[2];
  int w = 0;
  int h = 0;
  int counter = 0;
  int foodSize;
  int[][] food;
  List<int[]> snake = new ArrayList<>();
  public SnakeGame(int width, int height, int[][] food) {
    this.w = width;
    this.h = height;
    this.foodSize = food.length;
    this.food = food;
    this.snake.add(new int[]{0, 0});
  }
    
  public int move(String direction) {
      int[] tmp = this.snake.get(this.snake.size() - 1);
      int[] pos = new int[]{tmp[0], tmp[1]};
      if (direction.equals("R")) {
        pos[1] += 1;
      } else if (direction.equals("L")) {
        pos[1] -= 1;
      } else if (direction.equals("U")) {
        pos[0] -= 1;
      } else if (direction.equals("D")) {
        pos[0] += 1;
      }
      int x = pos[0];
      int y = pos[1];
      if (x < 0 || y < 0 || x >= h || y >= w) return -1;
      if (!valid(x, y, this.snake)) return -1;
      if (counter < this.foodSize && this.food[counter][0] == x && this.food[counter][1] == y) {
        counter++;
        this.snake.add(new int[]{x, y});
        return this.snake.size() - 1;
      }
      for (int i=0; i<this.snake.size() - 1; i++) {
        int[] cur = this.snake.get(i);
        int[] next = this.snake.get(i + 1);
        cur[0] = next[0];
        cur[1] = next[1];
      }
      //if (pos == tmp) return -1;
      tmp[0] = pos[0];
      tmp[1] = pos[1];
      return this.snake.size() - 1;
  }


  private boolean valid(int x, int y, List<int[]> list) {
    for (int i=1; i<list.size(); i++) {
      int[] arr = list.get(i);
      if (arr[0] == x && arr[1] == y) {
        return false;
      }
    }
    return true;
  }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
