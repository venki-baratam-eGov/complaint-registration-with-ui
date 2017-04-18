package org.complaint.domain.service;

import java.io.Serializable;
import java.sql.SQLException;

import org.complaint.persistence.util.DBSequenceGenerator;
import org.complaint.persistence.util.SequenceNumberGenerator;
import org.complaint.persistence.util.Utils;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrnGeneratorService {

    private SequenceNumberGenerator sequenceNumberGenerator;
    private DBSequenceGenerator dbSequenceGenerator;
    private Utils utils;

    private final String APP_NUMBER_SEQ_PREFIX = "SEQ_APPLICATION_NUMBER%s";

    public CrnGeneratorService(SequenceNumberGenerator sequenceNumberGenerator,
                               DBSequenceGenerator dbSequenceGenerator,
                               Utils utils) {
        this.sequenceNumberGenerator = sequenceNumberGenerator;
        this.dbSequenceGenerator = dbSequenceGenerator;
        this.utils = utils;
    }

    @Transactional
    public String getCRN() {
        try {
            final String currentYear = utils.currentDateToYearFormat();
            final String sequenceName = String.format(APP_NUMBER_SEQ_PREFIX, currentYear);
            final String randomAlphabets = utils.getRandomAlphabets();

            Serializable sequenceNumber;

            try {
                sequenceNumber = sequenceNumberGenerator.getNextSequence(sequenceName);
            } catch (final SQLGrammarException e) {
                sequenceNumber = dbSequenceGenerator.createAndGetNextSequence(sequenceName);
            }catch (final Exception e) {
                sequenceNumber = dbSequenceGenerator.createAndGetNextSequence(sequenceName);
            }

            return String.format("%05d-%s-%s", sequenceNumber, currentYear, randomAlphabets);
        } catch (final SQLException e) {
            throw new RuntimeException("Error occurred while generating Application Number", e);
        }
    }
}