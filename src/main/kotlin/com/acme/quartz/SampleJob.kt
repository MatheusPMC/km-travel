import com.acme.quartz.HelloJob
import org.quartz.JobBuilder.newJob
import org.quartz.JobDetail
import org.quartz.SimpleScheduleBuilder.simpleSchedule
import org.quartz.Trigger
import org.quartz.TriggerBuilder.newTrigger
import org.quartz.impl.StdSchedulerFactory

object App {


    @JvmStatic
    fun main(args: Array<String>) {
            val scheduler = StdSchedulerFactory.getDefaultScheduler()
            scheduler.start()
            val job: JobDetail = newJob(HelloJob::class.java)
                .withIdentity("job1", "group1")
                .build()

            val trigger: Trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(
                    simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever()
                )
                .build()
            scheduler.scheduleJob(job, trigger)
            System.`in`.read()

        }

}