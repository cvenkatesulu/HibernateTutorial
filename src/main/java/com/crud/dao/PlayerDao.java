package com.crud.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crud.dto.Player;
import com.crud.utils.HibernateUtils;

public class PlayerDao {

	/**
	 * This Method is used to Save Players
	 * 
	 * @param player
	 * @return
	 */
	public boolean savePlayer(Player player) {
		boolean isFinisied = false;
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionactory().openSession()) {
			tx = session.beginTransaction();
			Serializable savePlayers = session.save(player);
			if (savePlayers != null) {
				isFinisied = true;
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return isFinisied;
	}

	/**
	 * This method is used to update Players one by one
	 * 
	 * @return
	 */
	public String updatePlayerDetails() {

		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionactory().openSession()) {
			tx = session.beginTransaction();
			Player player = session.get(Player.class, 14);
			player.setPlayername("HP-LAPTOP");
			player.setTeamName("UNITED STATES");
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return "Player Details Updated Success!!";
	}

	/**
	 * This method used to implement findByPlayersId
	 * 
	 * @return
	 */
	public String findByPlayerId() {
		try (Session session = HibernateUtils.getSessionactory().openSession()) {
			Player player = session.get(Player.class, 14);
			System.out.println("Print Player Id Detaisl - " + player);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FindByPlayers Id Success!!";
	}
	
	/**
	 * This method is used to deleteBYlayes one by one
	 * @return
	 */
	public String deleteByPlayersId() {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionactory().openSession()) {
			tx = session.beginTransaction();
			Player player = session.get(Player.class, 13);
			System.out.println(player);
			session.delete(player);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "delete FindByPlayers Id Success!!";
	}

}
