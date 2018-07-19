// En4_6のキュー

public class Gqueue<E> {

	//--- 実行時例外：キューが空 ---//
	public static class EmptyGqueueException extends RuntimeException {
		public EmptyGqueueException() { }
	}

	//--- 実行時例外：キューが満杯 ---//
	public static class OverflowGqueueException extends RuntimeException {
		public OverflowGqueueException() { }
	}

	private int max;		// キューの容量
	private int num;		// 現在のデータ数
	private int front;		// 先頭要素カーソル
	private int rear;		// 末尾要素カーソル
	private E[] que;		// キューの本体

	//--- コンストラクタ ---//
	public Gqueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = (E [])new Object[max];				// キュー本体用の配列を生成
		} catch (OutOfMemoryError e) {	// 生成できなかった
			max = 0;
		}
	}

	//--- キューにデータをエンキュー ---//
	public E enque(E x) throws OverflowGqueueException {
		if (num >= max)
			throw new OverflowGqueueException();			// キューは満杯
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}

	//--- キューからデータをデキュー ---//
	public E deque() throws EmptyGqueueException {
		if (num <= 0)
			throw new EmptyGqueueException();			// キューは空
		E x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	//--- キューからデータをピーク（先頭データを覗く） ---//
	public E peek() throws EmptyGqueueException {
		if (num <= 0)
			throw new EmptyGqueueException();			// キューは空
		return que[front];
	}

	//--- キューからxを探してインデックス（見つからなければ-1）を返す ---//
	public int indexOf(E x) {
		for (int i = 0; i < num; i++)
			if (que[(i + front) % max] == x)				// 探索成功
				return i + front;
		return -1;								// 探索失敗
	}

	//--- キューからxを探して先頭から何番目か（見つからなければ-1）を返す ---//
	public int search(E x) {
		for (int i = 0; i < num; i++)
			if (que[(i + front) % max] == x)
				return i + 1;
		return -1;
	}

	//--- キューを空にする ---//
	public void clear() {
		num = front = rear = 0;
	}

	//--- キューの容量を返す ---//
	public int capacity() {
		return max;
	}

	//--- キューに蓄えられているデータ数を返す ---//
	public int size() {
		return num;
	}

	//--- キューは空であるか ---//
	public boolean isEmpty() {
		return num <= 0;
	}

	//--- キューは満杯であるか ---//
	public boolean isFull() {
		return num >= max;
	}

	//--- キュー内の全データを先頭→末尾の順に表示 ---//
	public void dump() {
		if (num <= 0)
			System.out.println("キューは空です。");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % max].toString() + " ");
			System.out.println();
		}
	}
}
