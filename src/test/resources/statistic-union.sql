(
SELECT '事件' AS eventType, elt(INTERVAL(INJURED_P_NUMBER, 0, 1, 3, 5, 10), '受伤-0', '受伤-1', '受伤-3', '受伤-5', '受伤-10') as subEventType, count(EVENT_TYPE) as counts, SUM(INJURED_P_NUMBER) as INJURED
FROM EGOV_DUTY_SUBMIT_REPORT
WHERE EVENT_TYPE = '事件' AND EVENT_TIME>='2009-06-02' AND EVENT_TIME<='2021-06-14'
GROUP BY subEventType
ORDER BY subEventType
)
UNION ALL(
SELECT '事件' AS eventType, elt(INTERVAL(INVOLVE_P_NUMBER, 1, 3, 5, 10), '涉及-1', '涉及-3', '涉及-5', '涉及-10') as subEventType, count(EVENT_TYPE) as counts, SUM(INJURED_P_NUMBER) as INJURED
FROM EGOV_DUTY_SUBMIT_REPORT
WHERE EVENT_TYPE = '事件' AND EVENT_TIME>='2009-06-02' AND EVENT_TIME<='2021-06-14'
GROUP BY subEventType
ORDER BY subEventType
)
UNION ALL(
    SELECT '案件' AS eventType, elt(INTERVAL(INJURED_P_NUMBER, 1, 2, 5, 10), '受伤-1', '受伤-2', '受伤-5', '受伤') as subEventType, count(EVENT_TYPE) as counts, SUM(INJURED_P_NUMBER) as INJURED
    FROM EGOV_DUTY_SUBMIT_REPORT
    WHERE EVENT_TYPE = '案件' AND EVENT_TIME>='2009-06-02' AND EVENT_TIME<='2021-06-14'
    GROUP BY subEventType
    ORDER BY subEventType )
UNION ALL(
        SELECT '环境污染' AS eventType, elt(INTERVAL(INJURED_P_NUMBER, 0, 3, 5, 10), '受伤-0', '受伤-3', '受伤-5', '受伤-10') as subEventType, count(EVENT_TYPE) as counts, SUM(INJURED_P_NUMBER) as INJURED
        FROM EGOV_DUTY_SUBMIT_REPORT
        WHERE EVENT_TYPE = '环境污染' AND EVENT_TIME>='2009-06-02' AND EVENT_TIME<='2021-06-14'
        GROUP BY subEventType
    	ORDER BY subEventType )