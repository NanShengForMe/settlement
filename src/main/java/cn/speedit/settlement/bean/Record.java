/**
 * 
 */
package cn.speedit.settlement.bean;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 *
 */
public class Record extends LinkedHashMap<String, Object> {

	private static final long serialVersionUID = 7652707548873175838L;

	/**
	 * @param data
	 */
	public Record() {
	}

	public static final int NORMAL = 0;
	public static final int INSERT = 1;
	public static final int UPDATE = 2;
	public static final int DELETE = 3;
	private int flag = NORMAL;

	public int getFlag() {
		return this.flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	/**
	 * @param data
	 */
	public Record(Map<String, Object> data) {
		super.putAll(data);
	}

	@Override
	public void clear() {
		super.clear();
	}

	@Override
	public Object clone() {
		return super.clone();
	}

	@Override
	public int size() {
		return super.size();
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public Object get(Object key) {
		return super.get(key);
	}

	public String getString(String key) {
		Object t = get(key);
		return t == null ? null : t.toString();
	}

	public boolean getBoolean(String key) {
		Object t = get(key);
		return t == null ? null : Boolean.parseBoolean(t.toString());
	}

	public byte getByte(String key) {
		Object t = get(key);
		return t == null ? null : Byte.parseByte(t.toString());
	}

	public short getShort(String key) {
		Object t = get(key);
		return t == null ? 0 : Short.parseShort(t.toString());
	}

	public int getInt(String key) {
		Object t = get(key);
		return t == null ? 0 : Integer.parseInt(t.toString());
	}

	public long getLong(String key) {
		Object t = get(key);
		return t == null ? 0 : Long.parseLong(t.toString());
	}

	public float getFloat(String key) {
		Object t = get(key);
		return t == null ? 0 : Float.parseFloat(t.toString());
	}

	public double getDouble(String key) {
		Object t = get(key);
		return t == null ? 0 : Double.parseDouble(t.toString());
	}

	public byte[] getBytes(String key) {
		Object t = get(key);
		return t == null ? null : (t.getClass().isArray() ? (byte[]) t : key.toString().getBytes());
	}

	public Date getDate(String key) {
		Object t = get(key);
		return t == null ? null : (Date) t;
	}

	@Override
	public boolean containsKey(Object key) {
		return super.containsKey(key);
	}

	@Override
	public Object put(String key, Object value) {
		return super.put(key, value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		super.putAll(m);
	}

	@Override
	public Object remove(Object key) {
		return super.remove(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return super.containsValue(value);
	}

	@Override
	public Set<String> keySet() {
		return super.keySet();
	}

	@Override
	public Collection<Object> values() {
		return super.values();
	}

	@Override
	public Set<Map.Entry<String, Object>> entrySet() {
		return super.entrySet();
	}

}
