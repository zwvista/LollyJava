/**
 * This class is generated by jOOQ
 */
package com.zwstudio.lolly.jooq.tables.records;


import com.zwstudio.lolly.jooq.tables.Etextbooks;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class EtextbooksRecord extends UpdatableRecordImpl<EtextbooksRecord> implements Record4<Integer, Integer, String, Integer> {

    private static final long serialVersionUID = 247753722;

    /**
     * Setter for <code>ETEXTBOOKS.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>ETEXTBOOKS.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>ETEXTBOOKS.LANGID</code>.
     */
    public void setLangid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>ETEXTBOOKS.LANGID</code>.
     */
    public Integer getLangid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>ETEXTBOOKS.NAME</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>ETEXTBOOKS.NAME</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>ETEXTBOOKS.PAGES</code>.
     */
    public void setPages(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>ETEXTBOOKS.PAGES</code>.
     */
    public Integer getPages() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Etextbooks.ETEXTBOOKS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Etextbooks.ETEXTBOOKS.LANGID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Etextbooks.ETEXTBOOKS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Etextbooks.ETEXTBOOKS.PAGES;
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
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getPages();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EtextbooksRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EtextbooksRecord value2(Integer value) {
        setLangid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EtextbooksRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EtextbooksRecord value4(Integer value) {
        setPages(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EtextbooksRecord values(Integer value1, Integer value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EtextbooksRecord
     */
    public EtextbooksRecord() {
        super(Etextbooks.ETEXTBOOKS);
    }

    /**
     * Create a detached, initialised EtextbooksRecord
     */
    public EtextbooksRecord(Integer id, Integer langid, String name, Integer pages) {
        super(Etextbooks.ETEXTBOOKS);

        set(0, id);
        set(1, langid);
        set(2, name);
        set(3, pages);
    }
}