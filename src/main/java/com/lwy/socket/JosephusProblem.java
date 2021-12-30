package com.lwy.socket;


/**
 * @Author 2021-12-15
 */
public class JosephusProblem {
    /**
     * 初始士兵数量
     */
    static Integer soldierNum = 40;
    /**
     * 士兵信息
     */
    static int[] soldiers =  new int[soldierNum];
    /**
     * 最小士兵数量
     */
    static Integer minLiveSoldier = 2;

    /**
     * 死亡值 -1 为士兵死亡
     */
    static Integer deadStatus = -1;

    public static void main(String[] args) {
        //赋值 方便查看 index
        for (int i = 0; i < soldierNum ; i ++){
            soldiers[i] = i;
        }
        killSoldier();
        for (int soldier : soldiers){
            //输出的 -1 为死亡士兵 非-1的为最终存活士兵
            System.out.print(soldier+" ");
        }
    }

    public static void killSoldier(){
        //单个士兵杀死士兵的数量 可能有跳过 需要记录
        int killSoldierNum = 0;
        for (int i = 0;i < soldiers.length ; i++){
            //杀人杀到尾巴了 从头在杀
            if(i == soldiers.length -1){
                i = 0;
            }
            //活着的数量小与2
            if(soldierNum <= minLiveSoldier){
                return;
            }
            //如果此士兵死亡就跳过
            if(soldiers[i] == deadStatus){
                continue;
            }
            //跳过两个人
            else if(killSoldierNum != 2){
                killSoldierNum ++;
            }
            //已经跳过两个 杀这个人
            else if(killSoldierNum == 2){
                soldiers[i] = deadStatus;
                killSoldierNum = 0;
                soldierNum --;
            }

        }

    }
}
