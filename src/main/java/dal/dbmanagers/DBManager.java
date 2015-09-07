package dal.dbmanagers;

import dal.connectors.HibernateConnector;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;

/**
 * Created by Yair on 07/09/2015.
 */

/**
 * basic db manager class, implementing most of the general methods
 * Created by sergeisafrigin on 2/2/15.
 */
public abstract class DBManager {
    //hibernate database session
    protected Session session;
    //used to update/insert/delete from/to the database
    protected Transaction updater;
    //the state of the session open(true)/closed(false)
    private boolean isSessionOpen;



    public DBManager() {
        isSessionOpen = false;
    }

    /**
     * open a session with the database if not open yet
     */
    protected void openSession() {
        if (!isSessionOpen) {
            session = HibernateConnector.getSession();
            isSessionOpen = true;
        }
    }

    /**
     * close the session with the database
     */
    protected void closeSession() {
        if (isSessionOpen) {
            session.close();
            isSessionOpen = false;
            updater = null;
        }
    }

    /**
     * gets updater from the session if not exist yet
     */
    protected void createUpdater() {
        if (updater == null)
            updater = session.beginTransaction();
    }

    /**
     * update the database
     */
    protected void saveUpdate() {
        if (updater != null)
            updater.commit();
    }

    /**
     * cancel the latest update (used when update is failed)
     */
    protected void cancelUpdate() {
        if (updater != null)
            updater.rollback();
    }

    /**
     * @return id of the latest inserted column
     */
    protected int getLastInsertedId() {
        return ((java.math.BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).intValue();
    }

    /**
     * deletes any entity from database
     *
     * @param entity
     */
    protected void deleteEntity(Object entity) {
        openSession();

        createUpdater();

        try {
            session.delete(entity);

            saveUpdate();
        } catch (HibernateException e) {
            cancelUpdate();
        } finally {
            closeSession();
        }
    }
    /**
     * add entity to database
     *
     * @param entity
     * @return
     */
    protected int createEntity(Object entity) {
        Integer id = null;

        openSession();

        try {
            createUpdater();

            id = (Integer) session.save(entity);

            saveUpdate();
        } catch (HibernateException e) {
            cancelUpdate();
        } finally {
            closeSession();
        }

        return id;
    }
    /**
     * update any entity to database
     *
     * @param entity
     */
    protected void updateEntity(Object entity) {

        openSession();

        createUpdater();

        try {
            //update db
            session.update(entity);

            saveUpdate();
        } catch (HibernateException e) {

            cancelUpdate();
        } finally {
            closeSession();
        }
    }

    protected void verifyNotNull(Object entity) {

    }

    /**
     * create bunch of entities
     * @param entities
     */
    protected void createEntities(Collection entities) {
        openSession();

        try {
            createUpdater();

            for(Object entity: entities){
                session.save(entity);
            }

            saveUpdate();
        } catch (HibernateException e) {
            cancelUpdate();
        } finally {
            closeSession();
        }
    }

    public void deleteEntities(Collection entities) {
        openSession();

        createUpdater();

        try {
            for(Object entity : entities){
                session.delete(entity);
            }
            saveUpdate();
        } catch (HibernateException e) {
            cancelUpdate();
        } finally {
            closeSession();
        }
    }

    public void updateEntities(Collection collection) {

        openSession();

        createUpdater();

        try {
            for(Object entity : collection){
                session.update(entity);
            }
            saveUpdate();
        } catch (HibernateException e) {
            cancelUpdate();
        } finally {
            closeSession();
        }
    }
}


