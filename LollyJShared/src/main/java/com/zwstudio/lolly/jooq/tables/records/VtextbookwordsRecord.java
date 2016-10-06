/**
 * This class is generated by jOOQ
 */
package com.zwstudio.lolly.jooq.tables.records;


import com.zwstudio.lolly.jooq.tables.Vtextbookwords;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class VtextbookwordsRecord extends TableRecordImpl<VtextbookwordsRecord> implements Record8<Integer, Integer, String, Integer, Integer, Integer, String, String> {

    private static final long serialVersionUID = -1143456015;

    /**
     * Setter for <code>VTEXTBOOKWORDS.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>VTEXTBOOKWORDS.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>VTEXTBOOKWORDS.LANGID</code>.
     */
    public void setLangid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>VTEXTBOOKWORDS.LANGID</code>.
     */
    public Integer getLangid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>VTEXTBOOKWORDS.TEXTBOOKNAME</code>.
     */
    public void setTextbookname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>VTEXTBOOKWORDS.TEXTBOOKNAME</code>.
     */
    public String getTextbookname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>VTEXTBOOKWORDS.UNIT</code>.
     */
    public void setUnit(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>VTEXTBOOKWORDS.UNIT</code>.
     */
    public Integer getUnit() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>VTEXTBOOKWORDS.PART</code>.
     */
    public void setPart(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>VTEXTBOOKWORDS.PART</code>.
     */
    public Integer getPart() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>VTEXTBOOKWORDS.SEQNUM</code>.
     */
    public void setSeqnum(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>VTEXTBOOKWORDS.SEQNUM</code>.
     */
    public Integer getSeqnum() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>VTEXTBOOKWORDS.WORD</code>.
     */
    public void setWord(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>VTEXTBOOKWORDS.WORD</code>.
     */
    public String getWord() {
        return (String) get(6);
    }

    /**
     * Setter for <code>VTEXTBOOKWORDS.NOTE</code>.
     */
    public void setNote(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>VTEXTBOOKWORDS.NOTE</code>.
     */
    public String getNote() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, Integer, String, Integer, Integer, Integer, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, Integer, String, Integer, Integer, Integer, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Vtextbookwords.VTEXTBOOKWORDS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Vtextbookwords.VTEXTBOOKWORDS.LANGID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Vtextbookwords.VTEXTBOOKWORDS.TEXTBOOKNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Vtextbookwords.VTEXTBOOKWORDS.UNIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Vtextbookwords.VTEXTBOOKWORDS.PART;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Vtextbookwords.VTEXTBOOKWORDS.SEQNUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Vtextbookwords.VTEXTBOOKWORDS.WORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Vtextbookwords.VTEXTBOOKWORDS.NOTE;
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
        return getUnit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getPart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getSeqnum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getWord();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getNote();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbookwordsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbookwordsRecord value2(Integer value) {
        setLangid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbookwordsRecord value3(String value) {
        setTextbookname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbookwordsRecord value4(Integer value) {
        setUnit(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbookwordsRecord value5(Integer value) {
        setPart(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbookwordsRecord value6(Integer value) {
        setSeqnum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbookwordsRecord value7(String value) {
        setWord(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbookwordsRecord value8(String value) {
        setNote(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VtextbookwordsRecord values(Integer value1, Integer value2, String value3, Integer value4, Integer value5, Integer value6, String value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VtextbookwordsRecord
     */
    public VtextbookwordsRecord() {
        super(Vtextbookwords.VTEXTBOOKWORDS);
    }

    /**
     * Create a detached, initialised VtextbookwordsRecord
     */
    public VtextbookwordsRecord(Integer id, Integer langid, String textbookname, Integer unit, Integer part, Integer seqnum, String word, String note) {
        super(Vtextbookwords.VTEXTBOOKWORDS);

        set(0, id);
        set(1, langid);
        set(2, textbookname);
        set(3, unit);
        set(4, part);
        set(5, seqnum);
        set(6, word);
        set(7, note);
    }
}