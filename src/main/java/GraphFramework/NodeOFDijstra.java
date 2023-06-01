/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphFramework;

public class NodeOFDijstra {
    private String id ;
   private  int dis ;

    public NodeOFDijstra(String id, int dis) {
        this.id = id;
        this.dis = dis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDis() {
        return dis;
    }

    public void setDis(int dis) {
        this.dis = dis;
    }
    
    
}
