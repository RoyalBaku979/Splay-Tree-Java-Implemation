package DTO;

import Function.SplayTree;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;


public class TransferObject {
    private  long result;
    private SplayTree splayTree;

    public TransferObject() {
    }

    public TransferObject(long result, SplayTree splayTree) {
        this.result = result;
        this.splayTree = splayTree;
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    public SplayTree getSplayTree() {
        return splayTree;
    }

    public void setSplayTree(SplayTree splayTree) {
        this.splayTree = splayTree;
    }
}
