package exam;

import java.util.List;

// TODO: ��������

public class PaginationHelper<I> {
    private List<I> collection=null;
    private int itemsPerPage = 0;

    /**
     * ���캯������
     * 1������collection����ʾ��Ҫ��ҳ������Ԫ��
     * 2������itemsPerPage����ʾÿҳ��Ԫ�ظ���
     */
 
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection =collection;
        this.itemsPerPage =itemsPerPage;
    }

    /**
     * ����collection������Ԫ�صĸ���
 
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     *  ����ҳ�� ��1��ʼ����
     */
    public int pageCount() {
    	return (collection.size() - collection.size()%itemsPerPage) / itemsPerPage + 1;
    }

    /**
      * ���ص�ǰҳpageIndex����������Ԫ�ظ���
     * pageIndex��0��ʼ����
     * ���pageIndexΪ�Ƿ�ֵ�򷵻�-1
     */
    public int pageItemCount(int pageIndex) {
        int pages = pageCount();
        if(pageIndex>pages-1 || pageIndex<0){
            return -1;
        }
        //���һҳ��������
        
        if(pageIndex == (pages-1)){
            return collection.size()-(pages-1)*itemsPerPage;
        }
        return itemsPerPage;
    }

    /**
      * ���ص�itemIndex��Ԫ�����ڵ�ҳ��
     * pageIndex��0��ʼ����
     * ���itemIndexΪ�Ƿ�ֵ�򷵻�-1
   
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex<0 || itemIndex>collection.size()){
            return -1;
        }
        return (itemIndex+1)/itemsPerPage;
    }
}