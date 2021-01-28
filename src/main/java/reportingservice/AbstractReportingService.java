package reportingservice;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
/**
 * This is an abstract class for the ReportingService class
 * @author esiumat
 *
 */
public abstract class AbstractReportingService implements PropertyChangeListener{

	/**
     * Adds listeners to this class.
     *
     * @param pcl a property change listener
     */
    public abstract void addPropertyChangeListener(PropertyChangeListener pcl);
    /**
     * Removes listeners to this class.
     *
     * @param pcl a property change listener
     */
    public abstract void removePropertyChangeListener(PropertyChangeListener pcl);

    /**
     * This method is called whenever a management service has a special change
     * (e.g. new account, updating user, new bundle)
     * <p>
     * It will respond by sending out the corresponding command to its listeners
     *
     * @param event an event from the management classes indicating the change
     */
    @Override
    public abstract void propertyChange(PropertyChangeEvent event);
	
}
