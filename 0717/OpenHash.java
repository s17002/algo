// オープンアドレス法によるハッシュ

public class openhash<k,v> {

	//--- バケットの状態 ---//
	enum status {occupied, empty, deleted};	// {データ格納, 空, 削除ずみ}

	//--- バケット ---//
	static class bucket<k,v> {
		private k key;						// キー値
		private v data;					// データ
		private status stat;				// 状態

		//--- コンストラクタ ---//
		bucket() {
			stat = status.empty;	// バケットは空
		}

		//--- 全フィールドに値を設定 ---//
		void set(k key, v data, status stat) {
			this.key  = key;			// キー値
			this.data = data;			// データ
			this.stat = stat;			// 状態
		}

		//--- 状態を設定 ---//
		void setstat(status stat) {
			this.stat = stat;
		}

		//--- キー値を返す ---//
		k getkey() {
			return key;
		}

		//--- データを返す ---//
		v getvalue() {
			return data;
		}

		//--- キーのハッシュ値を返す ---//
		public int hashcode() {
			return key.hashcode();
		}
	}

	private int size;						// ハッシュ表の大きさ
	private bucket<k,v>[] table;		// ハッシュ表

	//--- コンストラクタ ---//
	public openhash(int size) {
		try {
			table = new bucket[size];
			for (int i = 0; i < size; i++)
				table[i] = new bucket<k,v>();
			this.size = size;
		} catch (outofmemoryerror e) {		// 表を生成できなかった
			this.size = 0;
		}
	}

	//--- ハッシュ値を求める ---//
	public int hashvalue(object key) {
		return key.hashcode() % size;
	}

	//--- 再ハッシュ値を求める ---//
	public int rehashvalue(int hash) {
		return (hash + 1) % size;
	}

	//--- キー値keyをもつバケットの探索 ---//
	private bucket<k,v> searchnode(k key) {
		int hash = hashvalue(key);			// 探索するデータのハッシュ値
		bucket<k,v> p = table[hash];		// 着目バケット

		for (int i = 0; p.stat != status.empty && i < size; i++) {
			if (p.stat == status.occupied && p.getkey().equals(key))
				return p;
			hash = rehashvalue(hash);		// 再ハッシュ
			p = table[hash];
		}
		return null;
	}

	//--- キー値keyをもつ要素の探索（データを返却）---//
	public v search(k key) {
		bucket<k,v> p = searchnode(key);
		if (p != null)
			return p.getvalue();
		else
			return null;
	}

	//--- キー値key・データdataをもつ要素の追加 ---//
	public int add(k key, v data) {
		if (search(key) != null)
			return 1;							// このキー値は登録ずみ

		int hash = hashvalue(key);			// 追加するデータのハッシュ値
		bucket<k,v> p = table[hash];		// 着目バケット
		for (int i = 0; i < size; i++) {
			if (p.stat == status.empty || p.stat == status.deleted) {
				p.set(key, data, status.occupied);
				return 0;
			}
			hash = rehashvalue(hash);		// 再ハッシュ
			p = table[hash];
		}
		return 2;								// ハッシュ表が満杯
	}

	//--- キー値keyをもつ要素の削除 ---//
	public int remove(k key) {
		bucket<k,v> p = searchnode(key);	// 着目バケット
		if (p == null)
			return 1;							// このキー値は登録されていない

		p.setstat(status.deleted);
		return 0;
	}

	//--- ハッシュ表をダンプ ---//
	public void dump() {
		for (int i = 0; i < size; i++) {
			system.out.printf("%02d ", i);
			switch (table[i].stat) {
			 case occupied :
				system.out.printf("%s (%s)\n",
										table[i].getkey(), table[i].getvalue());
				break;

			 case empty :
			 	system.out.println("-- 未登録 --");	break;

			 case deleted :
			 	system.out.println("-- 削除ずみ --");	break;
			}
		}
	}
}
