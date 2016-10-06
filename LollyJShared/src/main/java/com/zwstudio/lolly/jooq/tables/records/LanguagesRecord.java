/**
 * This class is generated by jOOQ
 */
package com.zwstudio.lolly.jooq.tables.records;


import com.zwstudio.lolly.jooq.tables.Languages;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class LanguagesRecord extends UpdatableRecordImpl<LanguagesRecord> implements Record5<Integer, String, String, String, String> {

    private static final long serialVersionUID = 1444979288;

    /**
     * Setter for <code>LANGUAGES.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>LANGUAGES.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>LANGUAGES.NAME</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>LANGUAGES.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>LANGUAGES.VOICE</code>.
     */
    public void setVoice(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>LANGUAGES.VOICE</code>.
     */
    public String getVoice() {
        return (String) get(2);
    }

    /**
     * Setter for <code>LANGUAGES.CHNNAME</code>.
     */
    public void setChnname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>LANGUAGES.CHNNAME</code>.
     */
    public String getChnname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>LANGUAGES.ENGNAME</code>.
     */
    public void setEngname(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>LANGUAGES.ENGNAME</code>.
     */
    public String getEngname() {
        return (String) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Languages.LANGUAGES.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Languages.LANGUAGES.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Languages.LANGUAGES.VOICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Languages.LANGUAGES.CHNNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Languages.LANGUAGES.ENGNAME;
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
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getVoice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getChnname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getEngname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LanguagesRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LanguagesRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LanguagesRecord value3(String value) {
        setVoice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LanguagesRecord value4(String value) {
        setChnname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LanguagesRecord value5(String value) {
        setEngname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LanguagesRecord values(Integer value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LanguagesRecord
     */
    public LanguagesRecord() {
        super(Languages.LANGUAGES);
    }

    /**
     * Create a detached, initialised LanguagesRecord
     */
    public LanguagesRecord(Integer id, String name, String voice, String chnname, String engname) {
        super(Languages.LANGUAGES);

        set(0, id);
        set(1, name);
        set(2, voice);
        set(3, chnname);
        set(4, engname);
    }
}