
package dxc.kettle;

import org.apache.commons.lang.RandomStringUtils;
import org.pentaho.di.core.Const;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.Result;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.logging.KettleLogStore;
import org.pentaho.di.core.logging.LogLevel;
import org.pentaho.di.core.logging.LoggingBuffer;
import org.pentaho.di.core.plugins.PluginRegistry;
import org.pentaho.di.core.plugins.RepositoryPluginType;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.repository.RepositoriesMeta;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.RepositoryMeta;


public class Main {
	
	 public static void main(String[] args){
	
		runInternal("resources/pippo.kjb");
//		runInternal("resources/parameterized_job.kjb");
		
//		RunningJobs.main(null);
//		RunningJobs runningJobs = new RunningJobs();		
//		runningJobs.runJobFromFileSystem("resources/parameterized_job.kjb");
		
//		RunningTransformations.main(null);
//		RunningTransformations runningTransformations = new RunningTransformations();		
//		runningTransformations.runTransformationFromFileSystem("parameterized_transformation.ktr");
		
		
	}

	 
	
	
	public static void runInternal (String filename){

		try {
			KettleEnvironment.init();
			JobMeta jobMeta = new JobMeta(filename, null);
			Job job = new Job(null,jobMeta);
			job.setLogLevel(LogLevel.BASIC);
			job.start();
			job.waitUntilFinished();
			if(job.getErrors() != 0) {
				System.out.print("we have errors");
			}
			
		} catch (KettleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}




