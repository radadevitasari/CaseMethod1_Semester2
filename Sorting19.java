public class Sorting19 {
    void sortDenda(ClassPeminjaman19[] data) {
    for (int i = 1; i < data.length; i++) {
        ClassPeminjaman19 temp = data[i];
        int j = i - 1;

        while (j >= 0 && data[j].denda < temp.denda) {
            data[j + 1] = data[j];
            j--;
        }
        data[j + 1] = temp;
        }
    }
}
