/*
function solution(arr) {
  const uniqueArr = [...new Set(arr)];
  // uniqueArr.sort((a, b) => a - b); // 오름차순 정렬
  uniqueArr.sort((a, b) => b - a); // 내림차순 정렬
  return uniqueArr;
}

const arr = [1, 1, 3, 3, 0, 1, 1];

console.log(solution(arr));
*/

/*
function solution(numbers) {
  var answer = [];
  for (let i = 0; i < numbers.length; i++) {
    for (let j = 0; j < i; j++) {
      answer.push(numbers[i] + numbers[j]);
    }
  }
  return [...new Set(answer)].sort((a, b) => a - b);
}

const numbers = [5,0,2,7];

console.log(solution(numbers));
*/

/*
function solution(answers) {
  const answer = [];
  const supoja = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
  ];
  const scores = [0, 0, 0];

  for (let i = 0; i < answers.length; i++) {
    for (let j = 0; j < supoja.length; j++) {
      if (answers[i] === supoja[j][i % supoja[j].length]) {
        scores[j]++;
      }
    }
  }

  const maxScore = Math.max(...scores);

  for (let i = 0; i < 3; i++) {
    if (scores[i] === maxScore) {
      answer.push(i + 1);
    }
  }

  return answer;
}

const answers = [3, 1, 2, 3, 1, 3, 4, 4];

console.log(solution(answers) + "번 수포자가 가장 많이 맞추었습니다.");
*/

/*
function solution(arr1, arr2) {
  const r1 = arr1.length;
  const c1 = arr1[0].length;

  const r2 = arr2.length;
  const c2 = arr2[0].length;

  const ret = [];
  for (let i = 0; i < r1; i++) {
    ret.push(new Array(c2).fill(0));
  }

  for (let i = 0; i < r1; i++) {
    for (let j = 0; j < c2; j++) {
      for (let k = 0; k < c1; k++) {
        ret[i][j] += arr1[i][k] * arr2[k][j];
      }
    }
  }

  return ret;
}

const arr1 = [[1,4],[3,2],[4,1]];
const arr2 = [[3,3],[3,3]];

console.log(solution(arr1, arr2));
*/

/*
function solution(N, stages) {
  const challenger = new Array(N + 2).fill(0);
  // for (const stage of stages) {
  //   challenger[stage]++;
  // }
  for (let i = 0; i < stages.length; i++) {
    challenger[stages[i]]++;
  }

  const fails = {};
  let total = stages.length;

  for (let i = 1; i <= N; i++) {
    if (total === 0) {
      fails[i] = 0;
    } else {
      fails[i] = challenger[i] / total;
      total -= challenger[i];
    }

    const result = Object.entries(fails).sort((a, b) => {b[1] - a[1]});

    return result.map((v) => Number(v[0]));
  }
}
*/

/*
function solution(dirs) {
  const visited = new Set();
  const move = {
    U: [0, 1],
    D: [0, -1],
    R: [1, 0],
    L: [-1, 0],
  }

  let x = 0;
  let y = 0;

  for (const dir of dirs) {
    const [dx, dy] = move[dir];
    const nx = x + dx;
    const ny = y + dy;

    if (!(nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5)) {
      continue;
    }

    visited.add(`${x}${y}${nx}${ny}`);
    visited.add(`${nx}${ny}${x}${y}`);

    x = nx;
    y = ny;

  }

  return visited.size / 2;
}
*/

/*
const stack = [];
const maxSize = 5;

function isFull() {
  return stack.length === maxSize;
}

function isEmpty() {
  return stack.length === 0;
}

function push(stack, value) {
  if (isFull(stack)) {
    console.log('스택이 꽉 찼습니다.');
    return;
  } else {
    console.log('스택에 데이터를 추가합니다.');
    stack.push(value);
  }
}

function pop(stack) {
  if (isEmpty(stack)) {
    console.log('스택이 비었습니다.');
    return null;
  } else {
    console.log('스택에서 데이터를 추출합니다.');
    return stack.pop();
  }
}

let diverseSet = new Set();
diverseSet.add('text');
diverseSet.add(123);
diverseSet.add({key: 'value'});
diverseSet.add([1, 2, 3]);

console.log(diverseSet);
*/

/*
function parenthesesChecker(value) {
  const stack = [];
  const open = '({[<';
  const close = ')}]>';

  for (const char of value) {
    if (open.includes(char)) {
      stack.push(char);
    } else if (close.includes(char)) {
      if (stack.length === 0) {
        return false;
      } else {
        stack.pop();
      }
    } 
  }

  return stack.length === 0;
}

console.log(parenthesesChecker('<{[(<[]}>]>)'));

*/

/*
function solution(decimal) {
  const stack = [];

  while (decimal > 0) {
    stack.push(decimal % 2);
    decimal = Math.floor(decimal / 2);
  }

  let binary = '';
  while (stack.length > 0) {
    binary += stack.pop();
  }

  return binary;
}

console.log(solution(10));
*/

/*
function solution(s) {
  const n = s.length;
  let answer = 0;

  for (let i = 0; i < s.length; i++) {
    const stack = [];
    let isCorrect = true;
    for (let j = 0; j < n; j++) {
      const current =  s[(i + j) % n];

      if (current === '(' || current === '[' || current === '{') {
        stack.push(current);
      } else {
        if (stack.length === 0) {
          isCorrect = false;
          break;
        }

        const top = stack[stack.length - 1];

        if ((current === ')' && top === '(') ||
            (current === ']' && top === '[') ||
            (current === '}' && top === '{')) {
          stack.pop();
        } else {
          isCorrect = false;
          break;
        }
      }
    }
    if (isCorrect && stack.length === 0) {
      answer++;
    }
  }
  return answer;
}

const s = '[](){}';

console.log(solution(s));
*/

/*
function solution(string) {
  const stack = [];

  for (const char of string) {
    if (stack.length > 0 && stack[stack.length - 1] === char) {
      stack.pop();
    } else {
      stack.push(char);
    }
  }

  return stack.length === 0 ? 1 : 0;
}

const s = 'baabaab';

console.log(solution(s));
*/

/*
function solution(prices) {
  const n = prices.length;
  const answer = new Array(n).fill(0);

  const stack = [0];
  for (let i = 1; i < n; i++) {
    while (stack.length > 0 && prices[i] < prices[stack[stack.length - 1]]) {
      const j = stack.pop();
      answer[j] = i - j;
    }
    stack.push(i);
  }

  while (stack.length > 0) {
    const j = stack.pop();
    answer[j] = n - 1 - j;
  }

  return answer;
}

const prices = [1, 2, 3, 2, 3];

console.log(solution(prices));
*/

/*
function solution(board, moves) {
  const lanes = [...Array(board[0].length)].map(() => []);

  for (let i = board.length - 1; i >= 0; i--) {
    for (let j = 0; j < board[i].length; j++) {
      if (board[i][j] > 0) {
        lanes[j].push(board[i][j]);
      }
    }
  }

  const bucket = [];

  let answer = 0;

  for (const move of moves) {
    if (lanes[move - 1].length > 0) {
      const doll = lanes[move - 1].pop();
      if (bucket.length > 0 && bucket[bucket.length - 1] === doll) {
        bucket.pop();
        answer += 2;
      } else {
        bucket.push(doll);
      }
    }
  }

  return answer;
}

const board = [
  [0, 0, 0, 0, 0],
  [0, 0, 1, 0, 3],
  [0, 2, 5, 0, 1],
  [4, 2, 4, 4, 2],
  [3, 5, 1, 3, 1],
];

const moves = [1, 5, 3, 5, 1, 2, 1, 4];

console.log(solution(board, moves));
*/

class Queue {
  items = [];
  front = 0;
  rear = 0;

  constructor(array) {
    this.items = array;
    this.rear = array.length;
  }

  push(item) {
    this.items.push(item);
    this.rear++;
  }

  pop() {
    return this.items[this.front++];
  }

  isEmpty() {
    return this.front === this.rear;
  }

  size() {
    return this.rear - this.front;
  }

  first() {
    return this.items[this.front];
  }
}

/*
class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedListQueue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  push(data) {
    const newNode = new Node(data);

    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }

    this.size++;
  }

  pop() {
    if (!this.head) {
      return null;
    }

    const removeNode = this.head;
    this.head = this.head.next;

    if (!this.head) {
      this.tail = null;
    }

    this.size--;

    return removeNode.data;
  }

  isEmpty() {
    return this.size === 0;
  }

}

const queue = new Queue();
queue.push(1);
queue.push(2);

console.log(queue.pop());
console.log(queue.pop());

const linkedListQueue = new LinkedListQueue();
linkedListQueue.push(1);
linkedListQueue.push(2);

console.log(linkedListQueue.pop());
console.log(linkedListQueue.pop());
*/

/*
function solution(N, K) {
  const queue = new Queue();

  for (let i = 1; i <= N; i++) {
    queue.push(i);
  }

  while (queue.size() > 1) {
    for (let i = 0; i < K - 1; i++) {
      queue.push(queue.pop());
    }
    queue.pop();
  }

  return queue.pop();
}

const N = 5;
const K = 2;

console.log(solution(N, K));
*/

/*
function solution(progresses, speeds) {
  const answer = [];
  const n = progresses.length;

  const daysLeft = progresses.map((progresses, index) => Math.ceil((100 - progresses) / speeds[index]));

  let count = 0;
  let maxDay = daysLeft[0];

  for (let i = 0; i < n; i++) {
    if (daysLeft[i] <= maxDay) {
      count++;
    } else {
      answer.push(count);
      count = 1;
      maxDay = daysLeft[i];
    }
  }

  answer.push(count);
  return answer;
}
*/

/*
function solution(card1, card2, goal) {
  cards1 = new Queue(card1);
  card2 = new Queue(card2);
  goal = new Queue(goal);

  while (!goal.isEmpty()) {
    if (!cards1.isEmpty() && cards1.first() === goal.first()) {
      cards1.pop();
      goal.pop();
    } else if (!card2.isEmpty() && card2.first() === goal.first()) {
      card2.pop();
      goal.pop();
    } else {
      break;
    }
  }

  return goal.isEmpty() ? "Yes" : "No";
}
*/

function countSort(arr, k) {
  const hashTable = new Array(k + 1).fill(0);

  for (const num of arr) {
    if (num <= k) {
      hashTable[num] = 1;
    }
  }
  console.log(hashTable.length);
  return hashTable;
}

function solution(arr, target) {
  const hashTable = countSort(arr, targer);

  for (const num of arr) {
    const complement = target - num;

    if (complement !== num && complement >= 0 && complement <= target && hashTable[complement] === 1) {
      return true;
    }
  }
  return false;
}