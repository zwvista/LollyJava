/**
 * This class is generated by jOOQ
 */
package com.zwstudio.lolly.jooq.tables.records;


import com.zwstudio.lolly.jooq.tables.Vtextbooks;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VtextbooksRecord extends TableRecordImpl<VtextbooksRecord> implements Record9<Integer, Integer, String, Integer, String, String, String, String, String> {

    private static final long serialVersionUID = -1310804370;

    /**
     * Setter for <code>VTEXTBOOKS.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>VTEXTBOOKS.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>VTEXTBOOKS.LANGID</code>.
     */
    public void setLangid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>VTEXTBOOKS.LANGID</code>.
     */
    public Integer getLangid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>VTEXTBOOKS.TEXTBOOKNAME</code>.
     */
    public void setTextbookname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>VTEXTBOOKS.TEXTBOOKNAME</code>.
     */
    public String getTextbookname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>VTEXTBOOKS.UNITS</code>.
     */
    public void setUnits(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>VTEXTBOOKS.UNITS</code>.
     */
    public Integer getUnits() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>VTEXTBOOKS.PARTS</code>.
     */
    public void setParts(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>VTEXTBOOKS.PARTS</code>.
     */
    public String getParts() {
        return (String) get(4);
    }

    /**
     * Setter for <code>VTEXTBOOKS.USUNITFROM</code>.
     */
    public void setUsunitfrom(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>VTEXTBOOKS.USUNITFROM</code>.
     */
    public String getUsunitfrom() {
        return (String) get(5);
    }

    /**
     * Setter for <code>VTEXTBOOKS.USPARTFROM</code>.
     */
    public void setUspartfrom(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>VTEXTBOOKS.USPARTFROM</code>.
     */
    public String getUspartfrom() {
        return (String) get(6);
    }

    /**
     * Setter for <code>VTEXTBOOKS.USUNITTO</code>.
     */
    public void setUsunitto(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>VTEXTBOOKS.USUNITTO</code>.
     */
    public String getUsunitto() {
        return (String) get(7);
    }

    /**
     * Setter for <code>VTEXTBOOKS.USPARTTO</code>.
     */
    public void setUspartto(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>VTEXTBOOKS.USPARTTO</code>.
     */
    public String getUspartto() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Integer, String, Integer, String, String, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Integer, String, Integer, String, String, String, String, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Vtextbooks.VTEXTBOOKS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Vtextbooks.VTEXTBOOKS.LANGID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Vtextbooks.VTEXTBOOKS.TEXTBOOKNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Vtextbooks.VTEXTBOOKS.UNITS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Vtextbooks.VTEXTBOOKS.PARTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Vtextbooks.VTEXTBOOKS.USUNITFROM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Vtextbooks.VTEXTBOOKS.USPARTFROM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Vtextbooks.VTEXTBOOKS.USUNITTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Vtextbooks.VTEXTBOOKS.USPARTTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getLangid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getTextbookname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getUnits();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getParts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getUsunitfrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getUspartfrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getUsunitto();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getUspartto();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbooksRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbooksRecord value2(Integer value) {
        setLangid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbooksRecord value3(String value) {
        setTextbookname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbooksRecord value4(Integer value) {
        setUnits(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbooksRecord value5(String value) {
        setParts(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbooksRecord value6(String value) {
        setUsunitfrom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbooksRecord value7(String value) {
        setUspartfrom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbooksRecord value8(String value) {
        setUsunitto(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbooksRecord value9(String value) {
        setUspartto(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbooksRecord values(Integer value1, Integer value2, String value3, Integer value4, String value5, String value6, String value7, String value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VtextbooksRecord
     */
    public VtextbooksRecord() {
        super(Vtextbooks.VTEXTBOOKS);
    }

    /**
     * Create a detached, initialised VtextbooksRecord
     */
    public VtextbooksRecord(Integer id, Integer langid, String textbookname, Integer units, String parts, String usunitfrom, String uspartfrom, String usunitto, String uspartto) {
        super(Vtextbooks.VTEXTBOOKS);

        set(0, id);
        set(1, langid);
        set(2, textbookname);
        set(3, units);
        set(4, parts);
        set(5, usunitfrom);
        set(6, uspartfrom);
        set(7, usunitto);
        set(8, uspartto);
    }
}