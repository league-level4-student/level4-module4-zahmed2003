package quadraticSieve;

import java.util.Arrays;

public class Matrix {
	int[][] m;

	public Matrix(int[][] m) {
		this.m = m;
	}

	public void transpose() {
		int[][] t = new int[m[0].length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				t[j][i] = m[i][j];
			}
		}

		m = t;
	}

	public void switchRows(int rowA, int rowB) {
		int tmpRow[] = m[rowA];
		m[rowA] = m[rowB];
		m[rowB] = tmpRow;
	}

	public void rref() {
		int i = 0;
		int j = 0;
		boolean check = false;

	//	System.out.println(Arrays.deepToString(m).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
	//	System.out.println("");

		while (i < m.length && j < m[i].length) {
			while (m[i][j] == 0) {
				for (int k = i + 1; k < m.length; k++) {
					if (m[k][j] == 1) {
						switchRows(i, k);
						check = true;

						break;
					}
				}
				if (check != true) {
					j++;
				}
				if (check) {
					check = false;
					break;
				}

			}

			for (int k = 0; k < m.length; k++) {
				if (k != i && m[k][j] == 1) {
					for (int l = 0; l < m[0].length; l++) {
						m[k][l] = m[k][l] ^ m[i][l];
					}
				}
			}

		//	System.out.println(Arrays.deepToString(m).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
		//	System.out.println("");

			i++;
			j++;
		}

	}

	public static int[][] identity(int n) {
		int[][] id = new int[n][n];

		for (int i = 0; i < id.length; i++) {
			for (int j = 0; j < id[i].length; j++) {
				if (i == j) {
					id[i][j] = 1;
				} else {
					id[i][j] = 0;
				}
			}
		}

		return id;
	}

	public int[][] getArray() {
		return m;
	}

}