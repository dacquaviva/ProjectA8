package movements;

import java.util.HashMap;

import components.Position;

public class Action {

	private Position nextPosition;
	private HashMap<Position, Integer> sandMovement;
	private int cost=0;
	/**
	 * Action is the action of the Tractor on the Field.
	 * It is represented by the next position of the Tractor and the displacement of the sand on 
	 * the possible positions it can take
	 * 
	 * @param next
	 */
	public Action(Position next) {
		this.nextPosition = next;
		this.sandMovement = new HashMap<>();
	}
	
	public Position getNextPosition() {
		return nextPosition;
	}
	
	public int getCost() {
		for (Position p : sandMovement.keySet()) {
			this.cost+=sandMovement.get(p);
		}
		return this.cost+1 ;
	}
	
	public void setNextPosition(Position nextPosition) {
		this.nextPosition = nextPosition;
	}
	
	public HashMap<Position, Integer> getSandMovement() {
		return sandMovement;
	}
	
	public void setSandMovement(HashMap<Position, Integer> sandMovement) {
		this.sandMovement = sandMovement;
	}
	
	public void addElement(Position p, Integer i) {
		this.sandMovement.put(p, i);
	}
	
	@Override
	public String toString() {
		String ref="";
		ref+="("+this.nextPosition+") [";
		
		for(Position p:sandMovement.keySet()) {
			ref+=sandMovement.get(p).toString()+p.toString()+",";
		}
		ref+=this.cost+"]";
		return ref;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cost;
		result = prime * result + ((nextPosition == null) ? 0 : nextPosition.hashCode());
		result = prime * result + ((sandMovement == null) ? 0 : sandMovement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Action))
			return false;
		Action other = (Action) obj;
		if (cost != other.cost)
			return false;
		if (nextPosition == null) {
			if (other.nextPosition != null)
				return false;
		} else if (!nextPosition.equals(other.nextPosition))
			return false;
		if (sandMovement == null) {
			if (other.sandMovement != null)
				return false;
		} else if (!sandMovement.equals(other.sandMovement))
			return false;
		return true;
	}
	
	
	
}
