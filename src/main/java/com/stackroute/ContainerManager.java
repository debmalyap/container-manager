package com.stackroute;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class ContainerManager
{
    static Scanner sc = new Scanner(System.in);

    private int numberofContainers;
    private int numberofBoxes;
    private int containerVolume;
    private int boxVolume;
    private int totalVolume;
    private int remainingSpace;
    private int containerCapacity;
    private int availability;

    public void findSuitableContainer()
    {
        int containers[]={0,0,0,0,0};
        System.out.println("Enter the volume of the container:");
        containerVolume=sc.nextInt();
        System.out.println("Enter the volume of each box:");
        boxVolume=sc.nextInt();
        System.out.println("Enter the number of users:");
        numberofBoxes = sc.nextInt();
        int orders[]=new int[numberofBoxes];
        System.out.println("Enter the number of orders of each user:");
        for(int k=0;k<orders.length;k++)
        {
            orders[k]=sc.nextInt();
        }
        System.out.println("Containers before packing:");
        for(int i=0;i<containers.length;i++)
        {
            System.out.print("\t"+containers[i]);
        }
        System.out.println();
        containerCapacity=containerVolume/boxVolume;
        int remaining = 0;
        System.out.println("Updated containers:");
        int j=0;
        for (int i=0;i<containers.length;i++)
        {
            availability=containerCapacity-containers[i];
            if(availability>=orders[j])
            {
                containers[i]=orders[j];
                j++;
                if(j==orders.length)
                {
                    break;
                }
            }
            else if(availability<orders[j])
            {
                remaining=orders[j]-availability;
                containers[i]=availability;
                i++;
                containers[i]=remaining;
                j++;
                if(j==orders.length)
                {
                    break;
                }
            }
        }
        for (int i=0;i<containers.length;i++)
        {
            System.out.print("\t"+containers[i]);
        }
    }

    public void findTimeSlot() throws ParseException {
      //  SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy hh:mm");
//        String morning1Start,morning1End,noon1Start,noon1End,eve1Start,eve1End,morning2Start,morning2End,noon2Start,noon2End,eve2Start,eve2End;
//
//        DateFormat dateFormat=new SimpleDateFormat("hh:mm aa");
//
//        morning1Start="09:00 am";
//        Date slot1start=dateFormat.parse(morning1Start);
//
//        morning1End="12:00 pm";
//        Date slot1end=dateFormat.parse(morning1End);
//
//        noon1Start="01:00 pm";
//        Date slot2start=dateFormat.parse(noon1Start);
//
//        noon1End="04:00 pm";
//        Date slot2end=dateFormat.parse(noon1End);
//
//        eve1Start="05:00 pm";
//        Date slot3start=dateFormat.parse(eve1Start);
//
//        eve1End="08:00 pm";
//        Date slot3end=dateFormat.parse(eve1End);
//
//        morning1Start="09:00 am";
//        Date slot11start=dateFormat.parse(morning1Start);
//
//        morning1End="12:00 pm";
//        Date slot11end=dateFormat.parse(morning1End);
//
//        noon1Start="01:00 pm";
//        Date slot22start=dateFormat.parse(noon1Start);
//
//        noon1End="04:00 pm";
//        Date slot22end=dateFormat.parse(noon1End);
//
//        eve1Start="05:00 pm";
//        Date slot33start=dateFormat.parse(eve1Start);
//
//        eve1End="08:00 pm";
//        Date slot33end=dateFormat.parse(eve1End);
//        //System.out.println(dateFormat.format(slot33end));
//
//        System.out.println();
//        System.out.println("Enter the booking time:");
//        String time=sc.nextLine();
//        DateFormat date=new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
//        //System.out.println("ofioif"+date.parse());
//        Date datetime=date.parse(time);


//        if(datetime.after(slot1start) && datetime.before(slot1end))
//        {
//            System.out.println("Day-1 morning slot");
//        }
//        else if(datetime.after(slot2start) && datetime.before(slot2end))
//        {
//            System.out.println("Day-1 afternoon slot");
//        }
//        else if(datetime.after(slot3start) && datetime.before(slot3end))
//        {
//            System.out.println("Day-1 evening slot");
//        }
//        else if(datetime.after(slot11start) && datetime.before(slot11end))
//        {
//            System.out.println("Day-2 morning slot");
//        }
//        else if(datetime.after(slot22start) && datetime.before(slot22end))
//        {
//            System.out.println("Day-2 afternoon slot");
//        }
//        else if(datetime.after(slot33start) && datetime.before(slot33end))
//        {
//            System.out.println("Day-2 evening slot");
//        }
        Date slot1start=new SimpleDateFormat("dd/mm/yyyy HH:mm aa").parse("25/02/2019 09:00 am");
        System.out.println(slot1start.toString());
    }
    public static void main(String[] args) throws ParseException {
        ContainerManager containerManager = new ContainerManager();
        //containerManager.findSuitableContainer();
        containerManager.findTimeSlot();
    }

}
